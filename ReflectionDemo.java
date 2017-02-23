//       $Id: ReflectionDemo.java 27991 2015-04-21 13:21:21Z p20068 $
//      $URL: https://svn01.fh-hagenberg.at/bin/cepheiden/vocational/teaching/Material/langs/Java/Reflection/src/swe4/ReflectionDemo.java $
// $Revision: 27991 $
//     $Date: 2015-04-21 15:21:21 +0200 (Di., 21 Apr 2015) $
//   Creator: johann.heinzelreiter<AT>fh-hagenberg.at
//            peter.kulczycki<AT>fh-hagenberg.at
//   $Author: p20068 $

package swe4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//import org.apache.commons.lang3.StringUtils;

// -------------------------------------------------------------------------------------------------

interface ICalc {
   int add (int a, int b);
}

class Calc implements ICalc {
   public int add (int a, int b) {
      return a + b;
   }
}

// -------------------------------------------------------------------------------------------------

@SuppressWarnings ({"rawtypes", "unchecked"})
public class ReflectionDemo {
   public static void callMethod () {
      System.out.println ("Call method 'add':");

      try {
         Class c    = Class.forName ("swe4.Calc");   // loaded via -cp.
         ICalc calc = (ICalc) c.newInstance ();      //

         System.out.println ("3 + 5 = " + calc.add (3, 5));
         System.out.println ("3 + 5 = " + c.getMethods ()[0].invoke (calc, 3, 5));
         System.out.println ("3 + 5 = " + c.getMethod ("add", Integer.TYPE, Integer.TYPE).invoke (calc, 3, 5));

      } catch (Throwable e) {
         System.err.println (e);
      }
   }

   public static void showParameters (Class [] params) {
      for (int i = 0; i < params.length; i++) {
         System.out.println ("      parameter #" + i + ": " + params[i].getName ());
      }
   }

   public static void showMethods (Class c) {
      System.out.println ("Info for class '" + c.getName () + "':");
//    System.out.println (StringUtils.leftPad ("", c.getName ().length () + 18, '='));

      Constructor [] ctors = c.getConstructors ();
      Method []      meths = c.getMethods ();

      System.out.println ("Constructors:");

      for (Constructor ctor : ctors) {
         System.out.println ("   " + ctor.getName () + "():"); showParameters (ctor.getParameterTypes ());
         System.out.println ("");
      }

      System.out.println ("Methods:");

      for (Method meth : meths) {
         System.out.println ("   " + meth.getName () + "():"); showParameters (meth.getParameterTypes ());

         System.out.println ("      return: " + meth.getReturnType ());
         System.out.println ("");
      }
   }

   public static void main (String [] args) {
      try {
         Class c = new String ("abc").getClass ();
//       Class c = String.class;
//       Class c = Class.forName ("java.lang.String");

         showMethods (c);
         callMethod ();
      } catch (Throwable e) {
         System.out.println ("No such class: " + e);
      }
   }
}


/*
Info for class 'java.lang.String':
Constructors:
   java.lang.String():
      parameter #0: [B
      parameter #1: int
      parameter #2: int

   java.lang.String():
      parameter #0: [B
      parameter #1: java.nio.charset.Charset

   java.lang.String():
      parameter #0: [B
      parameter #1: java.lang.String

   java.lang.String():
      parameter #0: [B
      parameter #1: int
      parameter #2: int
      parameter #3: java.nio.charset.Charset

   java.lang.String():
      parameter #0: [B
      parameter #1: int
      parameter #2: int
      parameter #3: java.lang.String

   java.lang.String():
      parameter #0: java.lang.StringBuilder

   java.lang.String():
      parameter #0: java.lang.StringBuffer

   java.lang.String():
      parameter #0: [B

   java.lang.String():
      parameter #0: [I
      parameter #1: int
      parameter #2: int

   java.lang.String():

   java.lang.String():
      parameter #0: [C

   java.lang.String():
      parameter #0: java.lang.String

   java.lang.String():
      parameter #0: [C
      parameter #1: int
      parameter #2: int

   java.lang.String():
      parameter #0: [B
      parameter #1: int

   java.lang.String():
      parameter #0: [B
      parameter #1: int
      parameter #2: int
      parameter #3: int

Methods:
   equals():
      parameter #0: java.lang.Object
      return: boolean

   toString():
      return: class java.lang.String

   hashCode():
      return: int

   compareTo():
      parameter #0: java.lang.String
      return: int

   compareTo():
      parameter #0: java.lang.Object
      return: int

   indexOf():
      parameter #0: java.lang.String
      parameter #1: int
      return: int

   indexOf():
      parameter #0: java.lang.String
      return: int

   indexOf():
      parameter #0: int
      parameter #1: int
      return: int

   indexOf():
      parameter #0: int
      return: int

   valueOf():
      parameter #0: int
      return: class java.lang.String

   valueOf():
      parameter #0: long
      return: class java.lang.String

   valueOf():
      parameter #0: float
      return: class java.lang.String

   valueOf():
      parameter #0: boolean
      return: class java.lang.String

   valueOf():
      parameter #0: [C
      return: class java.lang.String

   valueOf():
      parameter #0: [C
      parameter #1: int
      parameter #2: int
      return: class java.lang.String

   valueOf():
      parameter #0: java.lang.Object
      return: class java.lang.String

   valueOf():
      parameter #0: char
      return: class java.lang.String

   valueOf():
      parameter #0: double
      return: class java.lang.String

   charAt():
      parameter #0: int
      return: char

   codePointAt():
      parameter #0: int
      return: int

   codePointBefore():
      parameter #0: int
      return: int

   codePointCount():
      parameter #0: int
      parameter #1: int
      return: int

   compareToIgnoreCase():
      parameter #0: java.lang.String
      return: int

   concat():
      parameter #0: java.lang.String
      return: class java.lang.String

   contains():
      parameter #0: java.lang.CharSequence
      return: boolean

   contentEquals():
      parameter #0: java.lang.CharSequence
      return: boolean

   contentEquals():
      parameter #0: java.lang.StringBuffer
      return: boolean

   copyValueOf():
      parameter #0: [C
      return: class java.lang.String

   copyValueOf():
      parameter #0: [C
      parameter #1: int
      parameter #2: int
      return: class java.lang.String

   endsWith():
      parameter #0: java.lang.String
      return: boolean

   equalsIgnoreCase():
      parameter #0: java.lang.String
      return: boolean

   format():
      parameter #0: java.util.Locale
      parameter #1: java.lang.String
      parameter #2: [Ljava.lang.Object;
      return: class java.lang.String

   format():
      parameter #0: java.lang.String
      parameter #1: [Ljava.lang.Object;
      return: class java.lang.String

   getBytes():
      parameter #0: int
      parameter #1: int
      parameter #2: [B
      parameter #3: int
      return: void

   getBytes():
      parameter #0: java.nio.charset.Charset
      return: class [B

   getBytes():
      parameter #0: java.lang.String
      return: class [B

   getBytes():
      return: class [B

   getChars():
      parameter #0: int
      parameter #1: int
      parameter #2: [C
      parameter #3: int
      return: void

   intern():
      return: class java.lang.String

   isEmpty():
      return: boolean

   join():
      parameter #0: java.lang.CharSequence
      parameter #1: [Ljava.lang.CharSequence;
      return: class java.lang.String

   join():
      parameter #0: java.lang.CharSequence
      parameter #1: java.lang.Iterable
      return: class java.lang.String

   lastIndexOf():
      parameter #0: int
      return: int

   lastIndexOf():
      parameter #0: java.lang.String
      return: int

   lastIndexOf():
      parameter #0: java.lang.String
      parameter #1: int
      return: int

   lastIndexOf():
      parameter #0: int
      parameter #1: int
      return: int

   length():
      return: int

   matches():
      parameter #0: java.lang.String
      return: boolean

   offsetByCodePoints():
      parameter #0: int
      parameter #1: int
      return: int

   regionMatches():
      parameter #0: int
      parameter #1: java.lang.String
      parameter #2: int
      parameter #3: int
      return: boolean

   regionMatches():
      parameter #0: boolean
      parameter #1: int
      parameter #2: java.lang.String
      parameter #3: int
      parameter #4: int
      return: boolean

   replace():
      parameter #0: char
      parameter #1: char
      return: class java.lang.String

   replace():
      parameter #0: java.lang.CharSequence
      parameter #1: java.lang.CharSequence
      return: class java.lang.String

   replaceAll():
      parameter #0: java.lang.String
      parameter #1: java.lang.String
      return: class java.lang.String

   replaceFirst():
      parameter #0: java.lang.String
      parameter #1: java.lang.String
      return: class java.lang.String

   split():
      parameter #0: java.lang.String
      return: class [Ljava.lang.String;

   split():
      parameter #0: java.lang.String
      parameter #1: int
      return: class [Ljava.lang.String;

   startsWith():
      parameter #0: java.lang.String
      parameter #1: int
      return: boolean

   startsWith():
      parameter #0: java.lang.String
      return: boolean

   subSequence():
      parameter #0: int
      parameter #1: int
      return: interface java.lang.CharSequence

   substring():
      parameter #0: int
      return: class java.lang.String

   substring():
      parameter #0: int
      parameter #1: int
      return: class java.lang.String

   toCharArray():
      return: class [C

   toLowerCase():
      parameter #0: java.util.Locale
      return: class java.lang.String

   toLowerCase():
      return: class java.lang.String

   toUpperCase():
      return: class java.lang.String

   toUpperCase():
      parameter #0: java.util.Locale
      return: class java.lang.String

   trim():
      return: class java.lang.String

   wait():
      return: void

   wait():
      parameter #0: long
      parameter #1: int
      return: void

   wait():
      parameter #0: long
      return: void

   getClass():
      return: class java.lang.Class

   notify():
      return: void

   notifyAll():
      return: void

   chars():
      return: interface java.util.stream.IntStream

   codePoints():
      return: interface java.util.stream.IntStream

Call method 'add':
3 + 5 = 8
3 + 5 = 8
3 + 5 = 8
*/
