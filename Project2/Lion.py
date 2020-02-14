import random
from Feline import Feline

class Lion(Feline):

  def __init__(self, name='Alex', awake=False, hungry=True, num_legs=4):
    super(Lion, self).__init__(name, awake, hungry, num_legs)

  def make_noise(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if(random_number < 0.25):
      print('{} the {} purred.'.format(self.name, animal_type))
    elif(random_number < 0.5):
      print('{} the {} grumbles.'.format(self.name, animal_type))
    else:
        print('{} the {} roars loudly.'.format(self.name, animal_type))
