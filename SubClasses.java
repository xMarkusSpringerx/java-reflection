//       $Id: SubClasses.java 31129 2016-04-19 17:44:01Z p20068 $
//      $URL: https://svn01.fh-hagenberg.at/bin/cepheiden/vocational/teaching/Material/langs/Java/Reflection/src/swe4/SubClasses.java $
// $Revision: 31129 $
//     $Date: 2016-04-19 19:44:01 +0200 (Di., 19 Apr 2016) $
//   Creator: peter.kulczycki<AT>fh-hagenberg.at
//   $Author: p20068 $

package swe4;

import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// -------------------------------------------------------------------------------------------------

final class InheritanceTree {
   private Map <Class <?>, Set <Class <?>>> map = new TreeMap <> (new ClassComparer ());

   static private final class ClassComparer implements Comparator <Class <?>> {
      @Override
      public int compare (Class <?> lhs, Class <?> rhs) {
         return lhs.getName ().compareTo (rhs.getName ());
      }
   }

// -----------------------------------------------

   public InheritanceTree () {
   }

// -----------------------------------------------

   public <T> void addSuperClassesOf (Class <?> c) {
      if (c != null) {
         Class <?> s = c.getSuperclass ();

         if (s != null) {
            if (!map.containsKey (s)) {
               map.put (s, newSet ());
            }

            map.get (s).add (c); addSuperClassesOf (c.getSuperclass ());
         }
      }
   }

   public Set <Class <?>> getAllSubClassesOf (Class <?> c) {
      Set <Class <?>> result = newSet (); getAllSubClassesOf (c, result); return result;
   }

   public Set <Class <?>> getDirectSubClassesOf (Class <?> c) {
      return map.containsKey (c) ? map.get (c) : newSet ();
   }

   public void write () {
      for (Map.Entry <Class <?>, Set <Class <?>>> e : map.entrySet ()) {
         System.out.println (e);
      }
   }

// -----------------------------------------------

   private static Set <Class <?>> newSet () {
      return new TreeSet <Class <?>> (new ClassComparer ());
   }

   private void getAllSubClassesOf (Class <?> c, Set <Class <?>> result) {
      result.addAll (getDirectSubClassesOf (c));

      for (Class <?> s : getDirectSubClassesOf (c)) {
         getAllSubClassesOf (s, result);
      }
   }
};

// -------------------------------------------------------------------------------------------------

final public class SubClasses {
   public static void main (String [] args) {
      InheritanceTree tree = new InheritanceTree ();

      tree.addSuperClassesOf (String .class);
      tree.addSuperClassesOf (TreeMap.class);
      tree.addSuperClassesOf (TreeSet.class);

      tree.write ();
      System.out.println ();

      System.out.println ("AbstractCollection: " + tree.getAllSubClassesOf (AbstractCollection.class));
      System.out.println ("Object:             " + tree.getAllSubClassesOf (Object.class));
      System.out.println ("String:             " + tree.getAllSubClassesOf (String.class));
   }
}


/*
class java.lang.Object=[class java.lang.String, class java.util.AbstractCollection, class java.util.AbstractMap]
class java.util.AbstractCollection=[class java.util.AbstractSet]
class java.util.AbstractMap=[class java.util.TreeMap]
class java.util.AbstractSet=[class java.util.TreeSet]

AbstractCollection: [class java.util.AbstractSet, class java.util.TreeSet]
Object:             [class java.lang.String, class java.util.AbstractCollection, class java.util.AbstractMap, class java.util.AbstractSet, class java.util.TreeMap, class java.util.TreeSet]
String:             []
*/
