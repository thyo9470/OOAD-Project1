from EatBehavior import EatBehavior

class DevourBehavior(EatBehavior):

  def eat(name, animal_type):
    print('{} the {} devoured their food'.format(name, animal_type)
