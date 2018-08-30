(ns clj-stellar-sdk.network
  #?(:clj (:import
            [org.stellar.sdk Network])
     :cljs (:require [stellar-sdk :refer [Network]])))

(defn current
  "Returns currently selected network."
  ^Network []
  (Network/current))

(defn id
  "Returns Network ID. Network ID is SHA-256 of network passphrase."
  ^String [^Network network]
  #?(:clj (String/valueOf (.getNetworkId network))
     :cljs (.networkId network)))

(defn passphrase
  "Returns network passphrase."
  ^String [^Network network]
  #?(:clj (.getNetworkPassphrase network)
     :cljs (.networkPassphrase network)))

(defn use-public!
  "Use Stellar Public Network."
  []
  (Network/usePublicNetwork))

(defn use-testnet!
  "Use Stellar Test Network."
  []
  (Network/useTestNetwork))

(defn use-passphrase!
  "Use the network with the given passphrase."
  [^String passphrase]
  (Network/use (new Network passphrase)))
