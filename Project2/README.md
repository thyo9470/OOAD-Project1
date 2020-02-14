# OOAD-Project2 Documentation


<b>Zoo Zoo Hullabaloo 2: Return of the Electric Zoogaloo</b> <br>
<i>Project 2 for Object Oriented Analysis and Design</i>

Cassidy Carpenter <br>
John Dibbards <br>
Thomas Young <br>

## Notes

1. Since Python has a handful of limitations such as lacking variable access modifiers (public, private, and protect) and not having a specific way to create abstract classes and interfaces we had to simulate these as best as we could.
    1. Abstract Classes: For an abstract class we did a few things to simulate their purpose in Java. This included not letting them be instantiated, only their subclasses. Also some functions had implementations while some were only templates.
    2. Interface: Similar to abstract clases, interfaces are unable to be instantiated, only classes that implement them. Each method within the interface is just a template and has no real implementation.
2. To make class methods only templates with no implementation we used:<br> `raise NotImplementedError('_____ needs override')`
3. The ZooKeeper states are stored as enums to ensure that there is no confusion around the zookeeper states

## Assumptions

1. For our programming language we chose python as an alternative OOP language due to all of our team members
being very famaliar with it already.
2. Similar to our Java program version of our Zoo implementation we generalized animal actions:
    1. **wakeUp**: Generally animals will not have too different of actions for waking up and for that reason this function is defined at the `Animal` class level. There could be some differences but for the purposes of our zoo we assume that they will all wake up when prompted.
    2. **makeNoise**: For the `makeNoise` function we decided to implement this in each level down to the 2nd sub-class. This is because every animal generally has a unique sound, even within a group of animals ( for example Tigers and cats ).
    3. **eat**: Similarly to `wakeUp` we decided to generalize eat to be the same for each animal. Although eating can vary, the soul function of eating would not change between animals. This being fueling the animal.
    4. **roam**: For `roam` we decided to implement this only down to the 1st sub-classes. This is becacuse we found that animals do roam/move around their environment differently, however, within a specific group they generally follow similar patterns of behaviors.
    5. **sleep**: Finally, for the `sleep` function we again only implemented this in the `Animal` class. Just like `wakeUp` and `eat` there is variations in how animals sleep, but the soul purpose/mechanics are very similar.
    
3. A new assumption was made about our behavior strategy pattern.
    1. **EatBehavior**: We used this class as our strategy pattern class where it could not be instantiated. However, we made serveral
    versions of `EatBehaior` that would override the `eat` function implemented in the Animal class. These EatBehaviors corresponded to each type 
    of animal. `BiteBehavior` corresponding to `Canines`, `DevourBehavior` corresponding to `Felines`, and `GrazeBehavior` corresponding to `Pachyderms`. 
4. Another assumption taken from Project1 was that the only purpose we saw in the `Zoo` class was to store the list of animals in the zoo. The `Zookeeper` would then just have a reference to the zoo to check what animals he needs to take care of.
Now with the addition of having to be observed by the `ZooAnnouncer`. Thus we decided that whenever the actions/states that the `ZooKeeper` was in would trigger the `ZooAnnounce`r to announce what the `ZooKeeper` was doing.
5. In regards to the observer `ZooAnnouncer`, we simply just had him deconstruct when our `ZooKeeper's` state was at "end". This is how we chose to implement the idea of the zoo keeper completeing all his tasks and the `ZooAnnouncer` acknowledges with a print statement that the zoo keeper is done with all his tasks for the day before deconstructing after this print statement. 
6. Again with assumptions taken from Project1 as Project2 is based off of our model for Project 1 we made the assumption that the `Zookeeper` would not store a list of the animals but instead have a reference to `Zoo` which does. This represents the `ZooKeeper` not needing to memorize all the zoo animals but to instead refer to some kind of resource that the zoo keeps on what animals are there.
