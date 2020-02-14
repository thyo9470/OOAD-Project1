import random
from Pachyderm import Pachyderm

class Elephant(Pachyderm):

  '''
    Generic initializer for Elephant
    @param name:String, default:'Ernest'
    @param awake:Boolean, default:False
    @param hungry:Boolean, deault:True
    @param num_legs:Int, default:4
  '''
  def __init__(self, name='Raymond', awake=False, hungry=True, num_legs=4):
    super(Elephant, self).__init__(name, awake, hungry, num_legs)

  '''
    Elephant can either trumpet or have a 20% chance to phoo-waompph
  '''
  def make_noise(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if random_number < 0.8:
      print('{} the {} trumpets.'.format(self.name, animal_type))
    else:
      print('{} the {} Phoo-waompphs.'.format(self.name, animal_type))

