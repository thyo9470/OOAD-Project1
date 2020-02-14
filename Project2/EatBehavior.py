'''
  Strategy pattern interface for eating behavior
'''
class EatBehavior():
  
  '''
    Makes EatBehavior not able to be instatiated
  '''
  def __new__(cls, *args, **kwargs):
          if cls is EatBehavior:
              raise TypeError("EatBehavior is an interface and cannot be instantiated")
          return object.__new__(cls, *args, **kwargs)

  '''
    Interface for eat function
  '''
  def eat(name, animal_type):
    raise NotImplementedError('eat needs override') 
