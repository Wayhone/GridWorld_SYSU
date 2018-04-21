# Design Report for Jumper 

---

## **Inception**

**a. What will a jumper do if the location in front of it is empty, but the location two cells in front contains a flower or a rock?**  
    if the location two cells in front contains a flower, then jump to the location and replace the flower.   
    if the location two cells in front contains a rock, turn its direction to the half-right.  

**b. What will a jumper do if the location two cells in front of the jumper is out of the grid?**  
    Turn its direction to the half-right.  

**c. What will a jumper do if it is facing an edge of the grid?**  
    Turn its direction to the half-right.

**d. What will a jumper do if another actor (not a flower or a rock) is in the cell that is two cells in front of the jumper?**  
    The jumper can replace the actor.

**e. What will a jumper do if it encounters another jumper in its path?**  
    One jumper can replace the other jumper.

**f. Are there any other tests the jumper needs to make?**  
    if the location in front contains an actor or a rock, but the location two cells in front of it is empty, jump over it.




