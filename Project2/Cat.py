import random
from Feline import Feline

class Cat(Feline):

  '''
    Generic initializer for Cat
    @param name:String, default:'Calex'
    @param awake:Boolean, default:False
    @param hungry:Boolean, deault:True
    @param num_legs:Int, default:4
  '''
  def __init__(self, name='Calex', awake=False, hungry=True, num_legs=4):
    super(Cat, self).__init__(name, awake, hungry, num_legs)

  '''
    Cat will make a noise with the following probability
      - 25% chance to purr
      - 25% chance to meow
      - 50% chance to miss with anger
  '''
  def make_noise(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if random_number < 0.25:
      print('{} the {} purred.'.format(self.name, animal_type))
    elif random_number < 0.5:
      print('{} the {} meows.'.format(self.name, animal_type))
    else:
      print('{} the {} hissed with anger.'.format(self.name, animal_type))

