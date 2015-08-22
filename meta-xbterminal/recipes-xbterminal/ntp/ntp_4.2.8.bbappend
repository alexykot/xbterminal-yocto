do_configure_prepend() {
    sed -i \
        -e "s|server 127|#server 127|" \
        -e "s|fudge 127|#fudge 127|" \
        -e "$ a server 0.pool.ntp.org" \
        -e "$ a server 1.pool.ntp.org" \
        -e "$ a server 2.pool.ntp.org" \
        -e "$ a server 3.pool.ntp.org" \
        ${WORKDIR}/ntp.conf
}
