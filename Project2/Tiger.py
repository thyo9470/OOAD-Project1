import random
from Feline import Feline

class Tiger(Feline):

  '''
    Generic initializer for Tiger
    @param name:String, default:'Tony'
    @param awake:Boolean, default:False
    @param hungry:Boolean, deault:True
    @param num_legs:Int, default:4
  '''
  def __init__(self, name='Tony', awake=False, hungry=True, num_legs=4):
    super(Tiger, self).__init__(name, awake, hungry, num_legs)

  '''
    A tiger will make a noise with the following probability
      - 25% chance to purr
      - 25% chance to grumble 
      - 50% chance to make a CHUFF sound
  '''
  def make_noise(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if(random_number < 0.25):
      print('{} the {} purred.'.format(self.name, animal_type))
    elif(random_number < 0.5):
      print('{} the {} grumbles.'.format(self.name, animal_type))
    else:
      print('{} the {} makes a CHUFF sound.'.format(self.name, animal_type))
