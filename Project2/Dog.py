import random
from Canine import Canine

class Dog(Canine):

  '''
    Generic initializer for Dog
    @param name:String, default:'Durk'
    @param awake:Boolean, default:False
    @param hungry:Boolean, deault:True
    @param num_legs:Int, default:4
  '''
  def __init__(self, name='Durk', awake=False, hungry=True, num_legs=4):
    super(Dog, self).__init__(name, awake, hungry, num_legs)

  '''
    Dog has a 80% chance to bark and 20% chance to whine
  '''
  def make_noise(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if random_number < 0.8:
      print('{} the {} barked.'.format(self.name, animal_type))
    else:
      print('{} the {} whined.'.format(self.name, animal_type))
      

