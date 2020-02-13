import random
from Canine import Canine

class Dog(Canine):

  def __init__(self, name='Durk', awake=False, hungry=True, numLegs=4):
    super(Canine, self).__init__(name, awake, hungry, numLegs)

  def make_noise(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if random_number < 0.8:
      print('{} the {} barked.'.format(self.name, animal_type))
    else:
      print('{} the {} whined.'.format(self.name, animal_type))
      

