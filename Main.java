import java.util.Random;
class Main{

static int iCount = 0; // Global variable
  
 public static void main(String[] args) {
   //int iNumbers[] = {34, 31, 12, 23, 47, 13, 28, 10};
   //int i;
   Random rand = new Random();
    
   //creating all loops
    int thous[]=new int[1000];
    for(int k=0; k<1000; k++){
      thous[k]=rand.nextInt(1000);
    }
   
  int twoThous[]=new int[2000];
    for(int k=0; k<2000; k++){
      twoThous[k]=rand.nextInt(2000);
    }

    int mostThous[]=new int[1000];
    for(int k=0; k<1000; k++){
      mostThous[k]=k;
    }
   for (int k=0; k<5; k++){
    int i= rand.nextInt(1000);
    int j= rand.nextInt(1000);
    int iTemp = mostThous[j];
    mostThous[j] = mostThous[i];
    mostThous[i] = iTemp;
   }
  
   int mostTwoThous[]=new int[2000];
    for(int k=0; k<2000; k++){
      mostTwoThous[k]=k;
    }
   for (int k=0; k<5; k++){
    int i= rand.nextInt(2000);
    int j= rand.nextInt(2000);
    int iTemp = mostTwoThous[j];
    mostTwoThous[j] = mostTwoThous[i];
    mostTwoThous[i] = iTemp;
   }

   int revThous[]=new int[1000];
    for(int k=999; k>=0; k--){
      revThous[999-k]=k;
    }
   int revTwoThous[]=new int[2000];
    for(int k=1999; k>=0; k--){
      revTwoThous[1999-k]=k;
    }

//set test to testing array
   int test[]=revThous;
   
//printArray(test);
   


   // Uncomment the line for the method you will use here.
   bubbleSort(test);
   //insertionSort(test);
   //selectionSort(test);
   //mergeSort(test, 0, test.length - 1);
   //quickSort(test, 0, test.length - 1);
   //heapSort(test);
 
   //System.out.println ("-----");
   //System.out.println ("Sorted array: ");
   //printArray(test);
   System.out.println ("Counter: " +iCount);
 }
 
 public static void printArray(int iArray[])
 {
   int iSize = iArray.length;
  
   for (int k = 0; k < iSize; k++)
     System.out.print (iArray[k] + " ");
   System.out.println();
 }

 // BUBBLE SORT
 public static void bubbleSort(int iArray[])
 {
   int iLength = iArray.length;
   int i, j;
   int iTemp;
   iCount++;
   for (i = 0; i < iLength - 1; i++){
     for (j = 0; j < iLength - i - 1; j++) {
       if (iArray[j] > iArray[j+1])
       {
         // Swap elements
         iTemp = iArray[j];
         iArray[j] = iArray[j+1];
         iArray[j+1] = iTemp;
         iCount+=3; 
       }
      //printArray (iArray); // Could go here to see the sorting pattern,
                          // But you don't want it for a large array.
        iCount++;
     }
     
   }
 }
 
 // INSERTION SORT
 public static void insertionSort(int iArray[])
 {
   int iLength = iArray.length;
   int i, j;
   int iTemp;
   
 
   for (i = 1; i < iLength; i++)
   {
     iTemp = iArray[i];
     j = i - 1;
     iCount+=2;
 
     // Shift elements #0 through i-1 that are greater
     // than iArray[i], one position to the right.
     while (j >= 0 && iArray[j] > iTemp) {
       iArray[j+1] = iArray[j];
       j--;
       iCount+=2;
     }
     iArray[j+1] = iTemp;
     iCount++;
   }
 }
// SELECTION SORT
 public static void selectionSort(int iArray[])
 {
   int iLength = iArray.length;
   int i, j;
   int iTemp;
   int idxMinLoc;
   iCount = 0;
 
   // Set boundary of unsorted array
   for (i = 0; i < iLength - 1; i++)
   {
     // Find location of minimum element in unsorted part
     idxMinLoc = i;
     for (j = i + 1; j < iLength; j++){
       if (iArray[j] < iArray[idxMinLoc]){
         idxMinLoc = j;
         iCount++;
       }
     iCount++;
         
    
     // Swap minimum element with first
     iTemp = iArray[idxMinLoc];
     iArray[idxMinLoc] = iArray[i];
     iArray[i] = iTemp;

       iCount+=3;
     }
   }
 }
 

// MERGE SORT: comes in two methods
 // sorts array[1 .. r] using merge()
 public static void mergeSort (int iArray[], int iLeft, int iRight)
 {
   if (iLeft < iRight) {
     // Find middle
     int iMid = iLeft + (iRight - iLeft)/2;
     iCount++;
 
     // Sort two pieces
     mergeSort (iArray, iLeft, iMid);
     mergeSort (iArray, iMid+1, iRight);
 
     // Merge
     merge (iArray, iLeft, iMid, iRight);
   }
   iCount++;
 }
 
 public static void merge(int iArray[], int iLeft, int iMid, int iRight)
 // Merges two subarrays of iArray[].
 // First is iArray[iLeft .. iMid]
 // Second is iArray[iMid + 1 .. iRight]
 {
   int i, j, k;
 
   // Find sizes of arrays
   int iSize1 = iMid - iLeft + 1;
   int iSize2 = iRight - iMid;
    //iCount+=2;
   // Temporary arrays
   int L[] = new int[iSize1];
   int R[] = new int[iSize2];
 
   // Copy to temp
   for (i = 0; i < iSize1; i++){
     L[i] = iArray[iLeft + i];
     iCount++;
   }
   for (j = 0; j < iSize2; j++){
     R[j] = iArray[iMid + 1 + j];
     iCount++;
   }
 
   // Merge
 
   // initial indexes
   i=0; j=0;
 
   // initial index of merged subarray
   k = iLeft;
   iCount++;
     
   while (i < iSize1 && j < iSize2) {
     if (L[i] <= R[j]) {
       iArray[k] = L[i];
       i++;
       iCount+=2;
     }
       
     else {
       iArray[k] = R[j];
       j++;
       iCount+=2;
     }
     k++;
     iCount+=2;
   }
 
   // Copy remaining elements of L[]
   while (i < iSize1) {
     iArray[k] = L[i];
     i++;
     k++;
     iCount+=3;
   }
   // Copy remaining elements of R[]
   while (j < iSize2) {
     iArray[k] = R[j];
     j++;
     k++;
     iCount+=3;
   }
   //System.out.println(iCount);
 }

 
// QUICK SORT: comes in two methods
 // main function to implement QuickSort
 public static void quickSort (int iArray[], int iLow, int iHigh)
 {
   if (iLow < iHigh)
   {
     // idxPart is partition index
     int idxPart = partition (iArray, iLow, iHigh);
     iCount++;
 
     // Sort each piece separately.
     quickSort(iArray, iLow, idxPart - 1);
     quickSort(iArray, idxPart + 1, iHigh);
   }
   iCount++;
   
 }
 
 // Take last element as pivot, place pivot at correct position in sorted array. Places smaller elements to the left of pivot, and greater elements to the right.
 public static int partition (int iArray[], int iLow, int iHigh)
 {
   int iPivot = iArray[iHigh];
   int i = iLow - 1;
   int iTemp;
   iCount+=2;
 
   for (int j = iLow; j <= iHigh - 1; j++)
   {
     // If current is smaller than pivot
     if (iArray[j] < iPivot)
     {
       i++; //increment index of smaller element
       iTemp = iArray[i];
       iArray[i] = iArray[j];
       iArray[j] = iTemp;
       //printArray(iArray);
       iCount+=4;
     }
     iCount++;
   }
   // swap again
   iTemp = iArray[i+1];
   iArray[i+1] = iArray[iHigh];
   iArray[iHigh] = iTemp;
   //printArray(iArray);
   iCount+=3;
   return (i+1);
 }

// HEAP SORT: 2 methods
 // main function to implement HeapSort
 public static void heapSort (int iArray[])
 {
   int iSize = iArray.length;
   int i;
   int iTemp;
   iCount++;
 
   // Build max heap (rearrange array)
   for (i = iSize/2 - 1; i >= 0; i--) // start and end and work back to start
     heapify (iArray, iSize, i);
 
   // Take elements off one by one
   for (i = iSize - 1; i > 0; i--) {
     // Move current root to end
     iTemp = iArray[0];
     iArray[0] = iArray[i];
     iArray[i] = iTemp;
     iCount+=3;
     // call max heapfiy on reduced heap
     heapify (iArray, i, 0);
   }
 }
 
 // Heapify a subtree
 public static void heapify (int iArray[], int iSize, int iRoot)
 {
   int iMax = iRoot; // largest is root
   int iLeft = 2 * iRoot + 1;
   int iRight = iLeft + 1;
   int iTemp;
   iCount+=3;
 
   // If left > root
   if (iLeft < iSize && iArray[iLeft] > iArray[iMax]){
     iMax = iLeft;
     iCount++;
   }
   iCount++;
 
   // If right greatest so far
   if (iRight < iSize && iArray[iRight] > iArray[iMax]){
     iMax = iRight;
     iCount++;
   }
   iCount++;
  
   // If largest is not root
   if (iMax != iRoot) {
     iTemp = iArray[iRoot];
     iArray[iRoot] = iArray[iMax];
     iArray[iMax] = iTemp;
     iCount+=3;
 
     // Recursively heapfiy subtree
     heapify(iArray, iSize, iMax);
   }
   iCount++;
 }
}


