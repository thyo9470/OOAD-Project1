from Zoo import Zoo
from Zookeeper import Zookeeper
from ZooAnnouncer import ZooAnnouncer

if __name__ == '__main__':

  zoo = Zoo()

  zookeeper = Zookeeper()
  zookeeper.set_zoo(zoo)

  zoo_announcer = ZooAnnouncer()
  zoo_announcer.start_observing(zookeeper) 

  zookeeper.work()
