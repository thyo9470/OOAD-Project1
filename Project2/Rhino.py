import random
from Pachyderm import Pachyderm

class Rhino(Pachyderm):

  '''
    Generic initializer for Rhino
    @param name:String, default:'Raymond'
    @param awake:Boolean, default:False
    @param hungry:Boolean, deault:True
    @param num_legs:Int, default:4
  '''
  def __init__(self, name='Raymond', awake=False, hungry=True, num_legs=4):
    super(Rhino, self).__init__(name, awake, hungry, num_legs)

  '''
    Rhino has a 1/3 chance to scream, trumpet, or scream and trumpet
  '''
  def make_noise(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if random_number < 0.33:
      print('{} the {} screams.'.format(self.name, animal_type))
    elif random_number <  0.67:
      print('{} the {} trumpets.'.format(self.name, animal_type))
    else:
      print('{} the {} screams and trumpets.'.format(self.name, animal_type))
      

