import random
from Feline import Feline

class Tiger(Feline):

  def __init__(self, name='Tony', awake=False, hungry=True, num_legs=4):
    super(Canine, self).__init__(name, awake, hungry, num_legs)

  def make_noise(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if(random_number < 0.25):
      print('{} the {} purred.'.format(self.name, animal_type))
    elif(random_number < 0.5):
      print('{} the {} grumbles.'.format(self.name, animal_type))
    else:
        print('{} the {} makes a CHUFF sound.'.format(self.name, animal_type))