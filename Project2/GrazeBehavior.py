from EatBehavior import EatBehavior

class GrazeBehavior(EatBehavior):

  def eat(name, animal_type):
    print('{} the {} grazed on some grass'.format(name, animal_type)
