package 双指针.搜索旋转排序数组;

public class leet33 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else
            if (nums[mid] == nums[r]) {
                r--;
            } else
                r = mid;
        }
        if (nums[l] == target) return l;
        if (nums[l] > target) return -1;
        //if target > nums[nums.length - 1] -> find in 0-l;
        //if target < nums[nums.length - 1] -> find in l-nums.length;
        if (target == nums[nums.length - 1]) return nums.length - 1;
        if (target > nums[nums.length - 1]) {
            r = l;
            l = 0;
            while (l <= r) {
                mid = (l + r) / 2;
                if (nums[mid] > target) {
                    r = mid - 1;
                }
                else if (nums[mid] < target) {
                    l = mid + 1;
                }
                else return mid;
            }

        }
        else if (target < nums[nums.length - 1]) {
            r = nums.length - 2;
            while (l <= r) {
                mid = (l + r) / 2;
                if (nums[mid] > target) {
                    r = mid - 1;
                }
                else if (nums[mid] < target) {
                    l = mid + 1;
                }
                else return mid;
            }
        }
        return -1;
    }

//    写法2：思路完全一样，把方法提出来
public int search1(int[] nums, int target) {
    int minIndex = findMinIndex(nums);
    int res = 0;
    if (target < nums[0]) {
        int l = minIndex;
        int r = nums.length;
        res = find(l,r,nums,target);
    }
    else if (target > nums[0]) {
        int l = 1;
        int r = minIndex - 1;
        res = find(l,r,nums,target);
    }
    return res;
}
    public int find(int l, int r, int[] nums, int target){
        int mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;
            else return mid;
        }
        return -1;
    }
    public int findMinIndex(int[] nums) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l < r) {
            mid = (l + r)/2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            }
            else if (nums[mid] < nums[r]) {
                r = mid;
            }
            else r--;
        }
        return r;
    }
}
