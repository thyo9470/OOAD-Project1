
import random
from Animal import Animal
from BiteBehavior import BiteBehavior

class Pachyderm(Animal):

  '''
    Generic initializer for Pachyderm
    @param name:String, default:'Paul'
    @param awake:Boolean, default:False
    @param hungry:Boolean, deault:True
    @param num_legs:Int, default:4
    @param eat_behavior:EatBehavior, default:BiteBehavior
  '''
  def __init__(self, name='Carl', awake=False, hungry=True, num_legs=4, eat_behavior=BiteBehavior):
    super(Pachyderm, self).__init__(name, awake, hungry, num_legs, eat_behavior)

  '''
    Pachyderm has a 33% chance to
    	-stomp around their enclosure
    	-step into the pool
    	-munch on nearby plants
    @override roam function from Animal
  '''
  def roam(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if random_number < 0.33 :
      print('{} the {} stomped around their enclosure.'.format(self.name, animal_type))
    elif random_number < 0.67 :
      print('{} the {} stepped into the pool.'.format(self.name, animal_type))
    else :
      print('{} the {} began munching on some nearby plants.'.format(self.name, animal_type))

  '''
    Pachyderm bellows
  '''
  def make_noise(self):
    animal_type = type(self).__name__
    print('{} the {} bellows'.format(self.name, animal_type))
