/* COMP 282  Project 2  
   September 30, 2014
   Instructor's Test Case 
*/

public class HeapTest
{

   public static void printArray( int[] x)
   {
      System.out.print("Print heap array: " );
      if( x.length == 0)
         System.out.println("Heap array is empty");
      else
      {
         for(int k = 0; k < x.length; k++)
            System.out.print(x[k] + "  ");
         System.out.println();
      }
   }
   
   public static void main(String[] args)throws HeapException
   {
      MaxIntHeap h2 = new MaxIntHeap();
      int[]z = { 44,-55,70,37,0, 52};
       
      System.out.println("Test 1  - heapInsert");            
      for ( int k = 0; k < z.length; k++)
         h2.heapInsert( z[k]);       
      printArray( h2.getHeapArray());
      
      
      System.out.println("\nTest 2: removeMax");
      while( !h2.isEmpty())
      {
         int max = h2.removeMax() ; 
         System.out.print("max = " + max + "  ");
         printArray(h2.getHeapArray()); 
      }
      
      MaxIntHeap h3 = new MaxIntHeap(3);
      System.out.println("\nTest 3:  max() and size ");
      h3.heapInsert(5);
      h3.heapInsert(55);
      h3.heapInsert(60);
      System.out.println("max = " + h3.max() + "   heapsize = " + h3.size());
      printArray(h3.getHeapArray()); 
      
      System.out.println("\nTest 4 :  modifyHeap");
      MaxIntHeap t = new MaxIntHeap();
      int[] b = {30, 20, -10, 15, 10, 8};
      for( int i = 0; i < b.length; i++)
         t.heapInsert(b[i]);
      printArray(t.getHeapArray());  
      t.modifyHeap(1, 5);
      printArray(t.getHeapArray()); 
      t.modifyHeap(5, 32);
      printArray(t.getHeapArray()); 
      
      System.out.print("\nTest 5: ");
      int[] w = {2,4,6,5,3};
      MaxIntHeap h1 = new MaxIntHeap(4);
      try
      {         
         for ( int k = 0; k < w.length; k++)
            h1.heapInsert( w[k]);
      } 
      catch(HeapException e)
      {
         System.out.println(e);
      }
      printArray(h1.getHeapArray()); 
      
      
      System.out.print ("\nTest 6:  ");
      try
      {         
         for ( int k = 0; k < w.length; k++)
            h1.removeMax();
      } 
      catch(HeapException e)
      {
         System.out.println(  e);
      }
      
      System.out.println("\nTest 7:  ");
      try
      {         
         h1.heapInsert(-40);
         h1.heapInsert(-4);
         printArray(h1.getHeapArray()); 
         while( !h1.isEmpty())
            System.out.print(h1.removeMax()+ "   " );
         System.out.println("  Heap size = " + h1.size());
         h1.max();
      }     
      catch(HeapException e)
      {
         System.out.println(  e);
      }
      
      System.out.print("\nTest 8:  " );
      try
      {
         h1.heapInsert(5);
         h1.heapInsert(12);
         h1.modifyHeap (3, 8);
      }
      catch( HeapException e)
      {
         System.out.println(e);
      }
      System.out.println("\nTesting Complete");
   }
}