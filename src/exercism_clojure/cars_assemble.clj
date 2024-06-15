(ns exercism-clojure.carsAssemble)

(defn success-rate
  [n]
  (case n
    0 0
    1 1
    2 1
    3 1
    4 1
    5 0.9
    6 0.9
    7 0.9
    8 0.9
    9 0.8
    10 0.77)
  )

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [cars-by-speed 221
        success-rate (success-rate speed),
        produce-cars (* speed cars-by-speed)]
    (* produce-cars success-rate))
  )

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60))
  )
