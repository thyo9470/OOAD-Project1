# OOAD-Project1 Documentation


<b>Zoo Zoo Hullabaloo</b> <br>
<i>Project 1 for Object Oriented Analysis and Design</i>

Cassidy Carpenter <br>
John Dibbards <br>
Thomas Young <br>


## Assumptions

1. We made the `Animal` class abstract since we did not see forsee needing to instantiate an animal. Instead we just wanted to create a template with a default constructor and functions.
2. For each function we made a few assumptions about how generalizable those actions would be amongst animals and species.
    1. **wakeUp**: Generally animals will not have too different of actions for waking up and for that reason this function is defined at the `Animal` class level. There could be some differences but for the purposes of our zoo we assume that they will all wake up when prompted.
    2. **makeNoise**: For the `makeNoise` function we decided to implement this in each level down to the 2nd sub-class. This is because every animal generally has a unique sound, even within a group of animals ( for example Tigers and cats ).
    3. **eat**: Similarly to `wakeUp` we decided to generalize eat to be the same for each animal. Although eating can vary, the soul function of eating would not change between animals. This being fueling the animal.
    4. **roam**: For `roam` we decided to implement this only down to the 1st sub-classes. This is becacuse we found that animals do roam/move around their environment differently, however, within a specific group they generally follow similar patterns of behaviors.
    5. **sleep**: Finally, for the `sleep` function we again only implemented this in the `Animal` class. Just like `wakeUp` and `eat` there is variations in how animals sleep, but the soul purpose/mechanics are very similar.
3. The only purpose we say in the `Zoo` class was to store the list of animals in the zoo. The `Zookeeper` would then just have a reference to the zoo to check what animals he needs to take care of.
4. Finally as mentioned before, the `Zookeeper` would not store a list of the animals but instead have a reference to `Zoo` which does. This represents the zookeeper not needing to memorize all the zoo animals but to instead refer to some kind of resource that the zoo keeps on what animals are there.
