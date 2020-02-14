import random
from Feline import Feline

class Cat(Feline):

  def __init__(self, name='Alex', awake=False, hungry=True, num_legs=4):
    super(Cat, self).__init__(name, awake, hungry, num_legs)

  def make_noise(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if random_number < 0.25:
      print('{} the {} purred.'.format(self.name, animal_type))
    elif random_number < 0.5:
      print('{} the {} meows.'.format(self.name, animal_type))
    else:
        print('{} the {} hissed with anger.'.format(self.name, animal_type))

