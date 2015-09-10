(ns meetup-test-check.test-ip
  (:require [meetup-test-check.core :as c]
            [clojure.test.check.generators :as gen]
            [clojure.test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]))

(def ip-gen (gen/fmap #(clojure.string/join "." %)
                      (gen/tuple (gen/choose 0 255)
                                 (gen/choose 0 255)
                                 (gen/choose 0 255)
                                 (gen/choose 0 255))))

(defspec ip-address-check
  10
  (prop/for-all [ip ip-gen]
    (c/ip-allowed? ip)))
