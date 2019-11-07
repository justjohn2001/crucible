(ns crucible.aws.kinesis
  "Resources in AWS::Kinesis::*"
  (:require [clojure.spec.alpha :as s]
            [crucible.resources :refer [spec-or-ref defresource]]
            [crucible.aws.global :as global]))

(s/def ::shard-count (spec-or-ref pos-int?))
(s/def ::retention-period-hours (spec-or-ref pos-int?))

(s/def ::name (spec-or-ref string?))

(s/def ::stream (s/keys :req [::shard-count]
                        :opt [::name
                              ::retention-period-hours
                              :crucible.resources/tags
                              ::global/depends-on]))

(defresource stream "AWS::Kinesis::Stream" ::stream)
