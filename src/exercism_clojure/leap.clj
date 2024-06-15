(ns exercism-clojure.leap)

(defn is-divisible-by-4?
  [year]
  (= (mod year 4) 0))

(defn is-divisible-by-100?
  [year]
  (= (mod year 100) 0))

(defn is-divisible-by-400?
  [year]
  (= (mod year 400) 0))

(defn leap-year? [year]
  (or
    (and (is-divisible-by-4? year) (and (not (is-divisible-by-100? year)) (not (is-divisible-by-400? year))))
    (and (is-divisible-by-4? year) (is-divisible-by-100? year) (is-divisible-by-400? year)))
  )

;(println (leap-year? 1997))
;(println (leap-year? 1900))
;(println (leap-year? 2000))

(println (leap-year? 1996))
(println (leap-year? 1960))