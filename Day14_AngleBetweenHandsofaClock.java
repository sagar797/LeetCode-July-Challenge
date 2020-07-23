//Problem:

Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.

Example 1:
Input: hour = 12, minutes = 30
Output: 165

Example 2:
Input: hour = 3, minutes = 30
Output: 75

Example 3:
Input: hour = 3, minutes = 15
Output: 7.5

Example 4:
Input: hour = 4, minutes = 50
Output: 155

Example 5:
Input: hour = 12, minutes = 0
Output: 0
 

Constraints:

1 <= hour <= 12
0 <= minutes <= 59
Answers within 10^-5 of the actual value will be accepted as correct.
   
Hint #1 :  
The tricky part is determining how the minute hand affects the position of the hour hand.
Hint #2 : 
Calculate the angles separately then find the difference.


//Solution: 

// The code uses following facts.

// Every hour, hour hand crosses 30 degree angle. ( 360 degreee / 12 hours = 30 degrees)
// Every minute, minute hand covers 6 degree angle. (360 degree / 60 minutes = 6 degree )
// Every minute, hour hand covers 0.5 degree angle. (30 degree / 60 minutes = 0.5 degree)
// Now we use above 3 facts to compute hourDegree for hour hand and minuteDegree for
// minute hands.
// We take absolute difference between them and return minimum of (diff, 360 - diff).

class Solution {
    public double angleClock(int hour, int minutes) {
        double hourDegree = hour * 30 % 360 + minutes * 0.5;
        double minuteDegree = minutes * 6;
        
        double answer = Math.abs(minuteDegree - hourDegree);
        
        return Math.min(answer, 360 -answer);
    }
}