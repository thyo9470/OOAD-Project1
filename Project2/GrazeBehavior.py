from EatBehavior import EatBehavior

'''
  Implementation for eating behavior strategy pattern
'''
class GrazeBehavior(EatBehavior):

  '''
    Animal grazes on grass
    @override eat function from EatBehavior
    @param name:String
    @param animal_type:String
  '''
  def eat(name, animal_type):
    print('{} the {} grazed on some grass'.format(name, animal_type)
