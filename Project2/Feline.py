#Imports
import random
from Animal import Animal
from DevourBehavior import DevourBehavior


#Class Feline extends Animal
class Feline(Animal):

#Initialize our Feline class with all default behaviors
#@param self
#@param
  def __init__(self, name='Rosie', awake=False, hungry=True, num_legs=4, eat_behavior=DevourBehavior):
    super(Feline, self).__init__(name, awake, hungry, num_legs, eat_behavior)

  def roam(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if random_number < 0.25 :
      print('{} the {} jumps around.'.format(self.name, animal_type))
    else:
        print('{} the {} knocks over a mug.'.format(self.name, animal_type))

  def make_noise(self):
    animal_type = type(self).__name__
    print('{} the {} meowed'.format(self.name, animal_type))

