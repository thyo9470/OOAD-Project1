from EatBehavior import EatBehavior

'''
  Implementation for eating behavior strategy pattern
'''
class DevourBehavior(EatBehavior):

  '''
    Animal devours their food
    @override eat function from EatBehavior
    @param name:String
    @param animal_type:String
  '''
  def eat(name, animal_type):
    print('{} the {} devoured their food'.format(name, animal_type))
