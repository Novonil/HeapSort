public class HeapSort
{
    public void Heapify(int[] arr, int n, int i)
    {
        int maximum = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int temp;
        if (left < n && arr[left] > arr[maximum])
        {
            maximum = left;
        }
        if (right < n && arr[right] > arr[maximum])
        {
            maximum = right;
        }
        if (maximum != i)
        {
            temp = arr[i];
            arr[i] = arr[maximum];
            arr[maximum] = temp;
            Heapify(arr, n, maximum);
        }
    }
    public void SortHeap(int[] arr)
    {
        int n = arr.length;
        
        int temp;
        int counter = 0;
        //Transform the binary tree into a complete binary tree 
        for(int i=n-1;i>=0;i--)
        {
            if(arr[i] == -1)
            {
                for (int j = i+1; j<n; j++)
                {
                    arr[j-1] = arr[j];
                }
                arr[n-1] = -1;
            }
            else
            {
                counter++;
            }
        }
        System.out.println("After Building a Complete Binary Tree");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //Heapify the complete binary tree
        int parent = counter / 2 - 1;
        for (int i = parent;i>=0;i--)
        {
            Heapify(arr, counter, i);
        }

        System.out.println("After Heapify");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //Heap Sort
        for (int i = counter - 1; i>=0; i--)
        {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            Heapify(arr, i, 0);
            System.out.println("After Heapifying");
            for (int j = 0; j < arr.length; j++)
            {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        int[] arr = { 1, 3, 9, 6, 211, 5, 32, 72, 11, 16, 93, 19, -1, -1, 12, -1, -1, 20, 7, 29 };
        int n = arr.length/2 - 1;

        //If any parent element is null then the array is invalid.
        for(int i = 0; i<=n;i++)
        {
            if(arr[i] == -1)
            {
                System.out.println("Invalid Array");    
                return;
            }           
        }

        // Print the original array
        System.out.println("Original Array");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //Sort the array
        HeapSort s = new HeapSort();
        s.SortHeap(arr);

        //Print the sorted array
        System.out.println("Sorted Array");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}