(ns exercism-clojure.triangle)

(defn is-valid? [x y z]
  (and
    (> (+ x y) z)
    (> (+ z y) x)
    (> (+ x z) y)
    (every? #(> % 0) [x y z]))
  )

(println (is-valid? 0 0 0))

(defn equilateral? [x y z]
  (if (is-valid? x y z) (= x y z) false)
  )

(println (equilateral? 0 0 0))

(defn isosceles? [x y z]
  (if (is-valid? x y z)
    (or
      (= x y)
      (= x z)
      (= y z)) false)
  )

(println (isosceles? 1 1 3))

(defn scalene? [x y z]                                           ;; <- arglist goes here
  (if (is-valid? x y z) (and (not= x y)
                             (not= x z)
                             (not= y z)) false)
  )

(println (scalene? 3 4 5))