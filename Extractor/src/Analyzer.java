import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Analyzer {

    public TreeMap analyze(ArrayList<String> pathsToJar) throws ClassNotFoundException {

        TreeMap tm = new TreeMap();

        JarFile jarFile = null;

        for (String pathToJar: pathsToJar) {

            try {
                jarFile = new JarFile(pathToJar);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Enumeration<JarEntry> e = jarFile.entries();

            URL[] urls = new URL[0];

            try {
                urls = new URL[]{new URL("jar:file:" + pathToJar + "!/")};
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }

            URLClassLoader cl = URLClassLoader.newInstance(urls);

            while (e.hasMoreElements()) {

                ClassInfo ci = new ClassInfo();

                JarEntry je = e.nextElement();
                if (je.isDirectory() || !je.getName().endsWith(".class")) {
                    continue;
                }
                // -6 because of .class
                String className = je.getName().substring(0, je.getName().length() - 6);
                className = className.replace('/', '.');

                //System.out.println(className);

                try {
                    Class c = cl.loadClass(className);
                    ci = analyzeClass(c);

                    ci.setClassName(className);

                    if (tm.get(ci.getClassName()) == null) {
                        Set<ClassInfo> hs = new HashSet();
                        hs.add(ci);
                        tm.put(ci.getClassName(), hs);
                    } else {
                        Set hs = (Set) tm.get(ci.getClassName());
                        hs.add(ci);
                        tm.put(ci.getClassName(), hs);
                    }
                } catch(NoClassDefFoundError | ClassNotFoundException ex) {
                }
            }
        }

        return tm;
    }

    public static int countParams (Class [] params) {
        return params.length;
    }


    public static float countAverageParams (Class c) {
        float sumAverageParams = 0;
        float counterAverageParams = c.getMethods().length;

        Method[]      meths = c.getMethods ();
        for (Method meth : meths) {
            //System.out.println ("   " + meth.getName () + "():");
            //System.out.println ("      return: " + meth.getReturnType ());

            sumAverageParams = sumAverageParams + meth.getParameterTypes().length;
            //System.out.println ("Anzahl Params: " + countParameters(meth.getParameterTypes ()));
        }

        return (sumAverageParams/counterAverageParams);
    }


    public static int countInterfaces(Class c) {
        return c.getInterfaces().length;
    }

    public static int countPrivateMethods(Class c) {
        int counter = 0;
        Method[] allMethods = c.getDeclaredMethods();
        for (Method method : allMethods) {
            if (Modifier.isPrivate(method.getModifiers())) {
                counter++;
            }
        }
        return counter;
    }

    public static int countProtectedMethods(Class c) {
        int counter = 0;
        Method[] allMethods = c.getDeclaredMethods();
        for (Method method : allMethods) {
            if (Modifier.isProtected(method.getModifiers())) {
                counter++;
            }
        }
        return counter;
    }

    public static int countPublicMethods(Class c) {
        int counter = 0;
        Method[] allMethods = c.getDeclaredMethods();
        for (Method method : allMethods) {
            if (Modifier.isPublic(method.getModifiers())) {
                counter++;
            }
        }
        return counter;
    }

    public static int countHierarchy(Class c) {
        int counter = 0;
        while (c != null) {
            c = c.getSuperclass();
            counter++;
        }
        return counter;
    }

    public static ClassInfo analyzeClass (Class c) {
        ClassInfo ci = new ClassInfo();

        ci.setCountInterfaces(countInterfaces(c));
        ci.setCountAverageParams(countAverageParams(c));

        ci.setCountPrivateMethods(countPrivateMethods(c));
        ci.setCountProtectedMethods(countProtectedMethods(c));
        ci.setCountPublicMethods(countPublicMethods(c));

        ci.setCountHierarchy(countHierarchy(c));

        return ci;
    }

}
