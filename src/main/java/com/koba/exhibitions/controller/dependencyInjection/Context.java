package com.koba.exhibitions.controller.dependencyInjection;


import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import org.reflections.Reflections;

public class Context {

    private Map<String, Object> applicationContext = new HashMap<>();

    interface Dao {

    }

    interface MysqlDao extends Dao {

    }

    @Component
    public static class ConcreteDao1 implements MysqlDao {

    }

    @Component
    public static class ConcreteDao2 implements MysqlDao {

    }

    @Component
    public static class ConcreteDao3 implements MysqlDao {

        private ConcreteDao1 concreteDao1;

        public ConcreteDao3(ConcreteDao1 concreteDao1) {
            this.concreteDao1 = concreteDao1;
        }
    }

    @SneakyThrows
    public void start() {
        getObject(ConcreteDao3.class);
    }

    @SneakyThrows
    public <T> T getObject(Class<T> clazz) {
        if (clazz.isAnnotationPresent(Component.class)) {
            T existingInstance = (T) applicationContext.get(clazz.getCanonicalName());
            if (existingInstance == null) {
                Constructor constructor = clazz.getDeclaredConstructors()[0];
                Class[] parameters = constructor.getParameterTypes();
                Object[] parametersObjects = Arrays.stream(parameters).map(cls -> getObject(cls)).collect(Collectors.toList()).toArray();
                Object instance = constructor.newInstance(parametersObjects);
                applicationContext.put(clazz.getCanonicalName(), instance);
                System.out.println(clazz.getCanonicalName() + " created");
                return clazz.cast(instance);
            }
            return existingInstance;
        } else {
            throw new RuntimeException("Can not created object of class " + clazz.getCanonicalName());
        }
    }

    public static void main(String[] args) {
        Context t = new Context();
        ConcreteDao3 c = t.getObject(ConcreteDao3.class);
        System.out.println("!!!"+c);
    }


    /**
     * Obtain all the class names under the package according to the package name
     *
     * @param pack
     * @return
     * @throws Exception
     */
    public static Set<Class<?>> getClasses(String pack) throws Exception {

        // The collection of the first class
        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
        // Whether to loop and iterate
        boolean recursive = true;
        // Get the package name and replace it
        String packageName = pack;
        String packageDirName = packageName.replace('.', '/');
        // Define an enumerated collection and loop to process things in this directory
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            // Iterate through the loop
            while (dirs.hasMoreElements()) {
                // Get the next element
                URL url = dirs.nextElement();
                // Get the name of the agreement
                String protocol = url.getProtocol();
                // If it is saved on the server as a file
                if ("file".equals(protocol)) {
                    // Get the physical path of the package
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    // Scan the files under the entire package as files and add them to the collection
                    findClassesInPackageByFile(packageName, filePath, recursive, classes);
                } else if ("jar".equals(protocol)) {
                    // If it is a jar package file
                    // Define a JarFile
                    System.out.println("jar type scan");
                    JarFile jar;
                    try {
                        // Get jar
                        jar = ((JarURLConnection) url.openConnection()).getJarFile();
                        // get an enum class from this jar package
                        Enumeration<JarEntry> entries = jar.entries();
                        findClassesInPackageByJar(packageName, entries, packageDirName, recursive, classes);
                    } catch (IOException e) {
                        // log.error ("Error in obtaining file from jar package when scanning user-defined view");
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classes;
    }

    /**
     * Get all Classes under the package in the form of files
     *
     * @param packageName
     * @param packagePath
     * @param recursive
     * @param classes
     */
    private static void findClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, Set<Class<?>> classes) {
        // Get the directory of this package Create a File
        File dir = new File(packagePath);
        // If it does not exist or it is not a directory, just return directly
        if (!dir.exists() || !dir.isDirectory()) {
            // log.warn ("user-defined package name" + packageName + "there is no file");
            return;
        }
        // If it exists, get all the files under the package, including the directory
        File[] dirfiles = dir.listFiles(new FileFilter() {
            // Custom filter rules if it can be looped (including subdirectories) or files ending in .class (compiled java class files)
            @Override
            public boolean accept(File file) {
                return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });
        // Loop all files
        for (File file : dirfiles) {
            // If it is a directory, continue scanning
            if (file.isDirectory()) {
                findClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
            } else {
                // If it is a java class file, remove the following .class and leave only the class name
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    // Add to collection
                    // classes.add(Class.forName(packageName + '.' +
                    // className));
                    // After replying to the reminder from the classmates, using forName here is not good, it will trigger the static method, and the load without classLoader is clean
                    classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));
                } catch (ClassNotFoundException e) {
                    // log.error ("Error adding user-defined view class cannot find such .class file");
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Get all Classes under the package in the form of jar
     *
     * @param packageName
     * @param entries
     * @param packageDirName
     * @param recursive
     * @param classes
     */
    private static void findClassesInPackageByJar(String packageName, Enumeration<JarEntry> entries, String packageDirName, final boolean recursive,
                                                  Set<Class<?>> classes) {
        // The same loop iteration
        while (entries.hasMoreElements()) {
            // Get an entity in the jar can be a directory and some other files in the jar package, such as META-INF and other files
            JarEntry entry = entries.nextElement();
            String name = entry.getName();
            // If it starts with /
            if (name.charAt(0) == '/') {
                // Get the following string
                name = name.substring(1);
            }
            // If the first half is the same as the defined package name
            if (name.startsWith(packageDirName)) {
                int idx = name.lastIndexOf('/');
                // If it ends with "/" is a packet
                if (idx != -1) {
                    // Get the package name and replace "/" with "."
                    packageName = name.substring(0, idx).replace('/', '.');
                }
                // If it can be iterated and it is a package
                if ((idx != -1) || recursive) {
                    // If it is a .class file and not a directory
                    if (name.endsWith(".class") && !entry.isDirectory()) {
                        // Remove the following ".class" to get the real class name
                        String className = name.substring(packageName.length() + 1, name.length() - 6);
                        try {
                            // Add to classes
                            classes.add(Class.forName(packageName + '.' + className));
                        } catch (ClassNotFoundException e) {
                            // .error ("Error adding user-defined view class cannot find such .class file");
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


}
