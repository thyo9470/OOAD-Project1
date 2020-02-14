import enum
from Subject import Subject

'''
  States for the Zookeeper
'''
class KeeperState(enum.Enum):
  start = 1
  wake_up = 2
  roll_call = 3
  feed_animals = 4
  exercise_animals = 5
  put_animals_to_bed = 6 
  end = 7

class Zookeeper(Subject):

  '''
    Generic initializer for Zookeeper
     - sets current state to indicate the beginning of a day
    @param zoo:Zoo - The zoo the Zookeeper works for
  '''
  def __init__(self, zoo=None):
    self.zoo = zoo
    self.state = KeeperState.start
    super(Zookeeper, self).__init__()

  '''
    Gets the current state of the Zookeeper
    @return state:KeeperState
  '''
  def get_state(self):
    return self.state  

  '''
    Preforms the Zookeepere daily tasks
  '''
  def work(self):
    self.wake_up_animals() 

  '''
    - Wakes up all the animals in the zoo 
    - Updates current state to wake_up
    - Notifies observers
  '''
  def wake_up_animals(self):
    for animal in self.zoo.get_animals():
      animal.wake_up()
    self.state = KeeperState.wake_up
    super().notify_observers()

  '''
    - Calls roll of animals in the zoo by having them make a noise
    - Updates current state to roll_call
    - Notifies observers
  '''
  def roll_call(self):
    for animal in self.zoo.get_animals():
      animal.make_noise() 
    self.state = KeeperState.roll_call
    super().notify_observers()
  
  '''
    - Feeds and the animals in the zoo 
    - Updates current state to feed_animals
    - Notifies observers
  '''
  def feed_animals(self):
    for animal in self.zoo.get_animals():
      animal.eat()
    self.state = KeeperState.feed_animals
    super().notify_observers()

  '''
    - Exercises the animals in the zoo 
    - Updates current state to exercise_animals
    - Notifies observers
  '''
  def exercise_animals(self):
    for animal in self.zoo.get_animals():
      animal.roam()
    self.state = KeeperState.exercise_animals
    super().notify_observers()

  '''
    - Puts all the animals in the zoo to sleep 
    - Updates current state to exercise_animals
    - Notifies observers
  '''
  def put_animals_to_bed(self):
    for animal in self.zoo.get_animals():
      animal.sleep()
    self.state = KeeperState.put_animals_to_bed
    super().notify_observers()
