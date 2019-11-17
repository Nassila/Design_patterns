# Design_patterns
application des patrons de conceptions sur de petits exemples, des diagrammes de classes sont ajouter pour aider 
à mieux comprendre les exemples :

  1- L'observateur :  nous avons une interface "Observateur" qui est implementée pas deux observateurs. Pour qu'un observateur 
     observe un sujet il doit s'abonner auprès de lui, l'observateur1 est abonné à Horloge, en d'autres termes l'observateur 1
     souhaite etre notifer de chaque changement d'heures. tandis que l'observateur2 est abonné à Date et souhaite connaître tous 
     les chagement de dates. Nous avons une classe abstraite "SujetObserve" qui contient trois méthodes; abonner, desabonner et notifier.
     Cette classe est herité de deux classe concretes filles "Horloge" et "Date".
     
  2- Stratégie : un super hero de la classe "SuperHero" utilise un pouvoir (qui représente une strategie) grace à l'interface 
     "StrategiePouvoir" qui est implementé par differents pouvoirs. un super hero peut executer son pouvoir à l'aide de la méthode 
     executePouvoir ou changer de pouvoir grace à la méthode setPouvoir.
     
  3- Fabrication : 
     
  

