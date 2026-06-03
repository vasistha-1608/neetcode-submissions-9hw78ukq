class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
      sum_set = set([])
      result = [[]]
      n  = len(nums)
      nums.sort()
      for i in range(0,n):
        left = i+1
        right = n-1
        while left<right:
            if nums[left] + nums[i] + nums[right] ==0: 
                sum_set.add((nums[i],nums[left],nums[right]))
                left +=1
                right -=1
            elif nums[left] + nums[i] + nums[right] >0:
                right -=1
            else :
                left +=1
    
      result = [list(item) for item in sum_set]

      return result
        