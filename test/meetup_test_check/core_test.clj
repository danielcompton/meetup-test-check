(ns meetup-test-check.core-test
  (:require [meetup-test-check.core :as m]
            [clojure.test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]))

(defspec sort-idempotent
  100
  (prop/for-all [v (gen/vector gen/int)]
    (= (sort v) (sort (sort v)))))

(defspec serialisation
  100
  (prop/for-all [edn gen/any]
    (= edn (read-string (pr-str edn)))))

(defspec sorting
  100
  (prop/for-all [int-vec (gen/vector gen/int)]
    (println int-vec)
    (= (sort int-vec) (m/custom-sort int-vec))))

(comment

  (gen/sample gen/int)

  (gen/sample (gen/vector gen/string))

  (nth (gen/sample-seq gen/string) 1)
  (nth (gen/sample-seq gen/string) 10)
  (nth (gen/sample-seq gen/string) 50)

  )

#_(defspec sum-now
    100
    (prop/for-all []))
