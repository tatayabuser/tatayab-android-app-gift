package com.tatayab.model.common

import java.io.IOException
import java.net.InetAddress
import java.net.Socket
import java.net.UnknownHostException
import javax.net.ssl.SSLSocket
import javax.net.ssl.SSLSocketFactory

class Tls12SocketFactory(internal val delegate: SSLSocketFactory) : SSLSocketFactory() {

    override fun getDefaultCipherSuites(): Array<String> {
        return delegate.defaultCipherSuites
    }

    override fun getSupportedCipherSuites(): Array<String> {
        return delegate.supportedCipherSuites
    }

     override fun createSocket(s: Socket, host: String, port: Int, autoClose: Boolean): Socket? {
        return patch(delegate.createSocket(s, host, port, autoClose))
    }

     override fun createSocket(host: String, port: Int): Socket? {
        return patch(delegate.createSocket(host, port))
    }

     override fun createSocket(host: String, port: Int, localHost: InetAddress, localPort: Int): Socket? {
        return patch(delegate.createSocket(host, port, localHost, localPort))
    }

     override fun createSocket(host: InetAddress, port: Int): Socket? {
        return patch(delegate.createSocket(host, port))
    }

     override fun createSocket(address: InetAddress, port: Int, localAddress: InetAddress, localPort: Int): Socket? {
        return patch(delegate.createSocket(address, port, localAddress, localPort))
    }

    private fun patch(s: Socket): Socket {
        if (s is SSLSocket) {
            s.enabledProtocols = TLS_V12_ONLY
        }
        return s
    }

    companion object {
        private val TLS_V12_ONLY = arrayOf("TLSv1.2")
        private val TLS_V1X = arrayOf("TLSv1.1", "TLSv1.2")
    }
}