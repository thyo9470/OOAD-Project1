import random
from Pachyderm import Pachyderm

class Hippo(Pachyderm):

  '''
    Generic initializer for Hippo
    @param name:String, default:'Harold'
    @param awake:Boolean, default:False
    @param hungry:Boolean, deault:True
    @param num_legs:Int, default:4
  '''
  def __init__(self, name='Harold', awake=False, hungry=True, num_legs=4):
    super(Hippo, self).__init__(name, awake, hungry, num_legs)

  '''
    Hippo has an equal chance to make one of 5 sounds
  '''
  def make_noise(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if random_number < 0.2:
      print('{} the {} grunts.'.format(self.name, animal_type))
    elif random_number <  0.4:
      print('{} the {} groans.'.format(self.name, animal_type))
    elif random_number < 0.6:
      print('{} the {} growls.'.format(self.name, animal_type))
    elif random_number < 0.8:
      print('{} the {} wheezes.'.format(self.name, animal_type))
    else:
      print('{} the {} chuffs.'.format(self.name, animal_type))
      

