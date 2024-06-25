(ns exercism_clojure.coordinate_transformation)

(defn translate2d
  [dx dy]
  (fn [x y] [(+ dx x) (+ dy y)]))

(defn scale2d
  [sx sy]
  (fn [x y] [(* sx x) (* sy y)]))

(defn compose-transform
  [f g]
  (fn [x y] (apply g (f x y))))


(defn memoize-transform
  [f]
  (let [memoized (atom {:last-x nil
                        :last-y nil
                        :last-result nil})]
    (fn [x y]
      (if
        (and
          (= x (:last-x @memoized))
          (= y (:last-y @memoized)))
        (:last-result @memoized)
        (let [new-result (f x y)]
          (swap! memoized assoc :last-x x)
          (swap! memoized assoc :last-y y)
          (swap! memoized assoc :last-result new-result)
          new-result)))))