public class loops_v1 {
   public static void main(String[] arsg) {
      /*
!!!!!!!!!!!!!!!!!!!!!!
\\!!!!!!!!!!!!!!!!!!//
\\\\!!!!!!!!!!!!!!////
\\\\\\!!!!!!!!!!//////
\\\\\\\\!!!!!!////////
\\\\\\\\\\!!//////////
      */
      for (int i=0; i<6; i++) { //6 rows
         for (int j=0; j<6; j++) { //6 collumns
            if (j >= 0+i)
               System.out.print("!!");
            else
               System.out.print("\\\\");
         }
         for (int j=4; j>=0; j--) { //5 collumns
            if (j >= 0+i)
               System.out.print("!!");
            else
               System.out.print("//");
         }
         System.out.println();
      }
/*
                     o  ****** *
                    /|\ *      *
                    / \ *      *
                 o  ******     * 
                /|\ *          *
                / \ *          *
            o  ******          *
           /|\ *               *
           / \ *               *
       o  ******               *
      /|\ *                    *
      / \ *                    *
 o  ******                     *
/|\ *                          *
/ \ *                          *
********************************
*/
      
/*
     /**\
    //**\\
   ///**\\\
  ////**\\\\
 /////**\\\\\
+=*=*=*=*=*=*+
|../\..../\..|
|./\/\../\/\.|
|/\/\/\/\/\/\|
|\/\/\/\/\/\/|
|.\/\/..\/\/.|
|..\/....\/..|
+=*=*=*=*=*=*+
|\/\/\/\/\/\/|
|.\/\/..\/\/.|
|..\/....\/..|
|../\..../\..|
|./\/\../\/\.|
|/\/\/\/\/\/\|
+=*=*=*=*=*=*+
    /**\
   //**\\
  ///**\\\
 ////**\\\\
/////**\\\\\




            ||
            ||
            ||
            ||
         __/||\__
      __/:::||:::\__
   __/::::::||::::::\__
__/:::::::::||:::::::::\__
|""""""""""""""""""""""""|
\_/\/\/\/\/\/\/\/\/\/\/\_/
  \_/\/\/\/\/\/\/\/\/\_/
    \_/\/\/\/\/\/\/\_/
      \_/\/\/\/\/\_/
            ||
            ||
            ||
            ||
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         __/||\__
      __/:::||:::\__
   __/::::::||::::::\__
__/:::::::::||:::::::::\__
|""""""""""""""""""""""""|
         */
    }
}
