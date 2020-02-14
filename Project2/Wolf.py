import random
from Canine import Canine

class Wolf(Canine):

  '''
    Generic initializer for Wolf
    @param name:String, default:'Wale'
    @param awake:Boolean, default:False
    @param hungry:Boolean, deault:True
    @param num_legs:Int, default:4
  '''
  def __init__(self, name='Wale', awake=False, hungry=True, num_legs=4):
    super(Wolf, self).__init__(name, awake, hungry, num_legs)

  '''
    Wolf has a 50% chance to either howl or agressively growl
  '''
  def make_noise(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if random_number < 0.5:
      print('{} the {} howled.'.format(self.name, animal_type))
    else:
      print('{} the {} aggressively growled.'.format(self.name, animal_type))
      

