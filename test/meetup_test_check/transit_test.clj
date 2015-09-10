(ns meetup-test-check.transit-test
  (:require [cognitect.transit :as t]
            [clojure.test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]])
  (:import (java.io ByteArrayInputStream ByteArrayOutputStream)))

(defspec round-trip-transit
  100
  (prop/for-all [any gen/any]
    (= any
       (let [baos (ByteArrayOutputStream. 512)]
         (t/write (t/writer baos :json) any)
         (t/read (t/reader (ByteArrayInputStream. (.toByteArray baos)) :json))))))
