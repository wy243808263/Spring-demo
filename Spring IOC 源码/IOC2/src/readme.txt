为了解决ServiceImpl不但依赖Dao层的接口，还依赖其实现的缺点，引入IoC容器


优点：
Service层不再依赖Dao层的实现，而把这种对实现的依赖交给了容器
缺点：
Service层实现依赖了Container容器类，使得组件不能脱离容器独立存在，显然，这是一种“侵入式”的管理。
