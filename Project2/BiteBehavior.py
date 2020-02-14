from EatBehavior import EatBehavior

'''
  Implementation for eating behavior strategy pattern
'''
class BiteBehavior(EatBehavior):

  '''
    Animal bites their food
    @override eat function from EatBehavior
    @param name:String
    @param animal_type:String
  '''
  def eat(name, animal_type):
    print('{} the {} began to bite thier food'.format(name, animal_type))
