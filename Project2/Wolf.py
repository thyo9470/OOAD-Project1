import random
from Canine import Canine

class Wolf(Canine):

  def __init__(self, name='Wale', awake=False, hungry=True, num_legs=4):
    super(Canine, self).__init__(name, awake, hungry, num_legs)

  def make_noise(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if random_number < 0.5:
      print('{} the {} howled.'.format(self.name, animal_type))
    else:
      print('{} the {} aggressively growled.'.format(self.name, animal_type))
      

