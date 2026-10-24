ARG BUILD_FROM=ghcr.io/hassio-addons/debian-base:9.5.1
# hadolint ignore=DL3006
FROM ${BUILD_FROM}

# Set shell
SHELL ["/bin/bash", "-o", "pipefail", "-c"]

# Setup base
# hadolint ignore=DL3008
RUN apt-get -qq update \
    && apt-get -qq install --no-install-recommends -y nginx \
    && rm -rf /var/lib/apt/lists/*

# Copy root filesystem
COPY rootfs /

# Nginx answers 403 to every client but the ingress gateway, so any HTTP reply means healthy.
HEALTHCHECK --interval=30s --timeout=5s --start-period=30s \
    CMD curl -s -o /dev/null http://127.0.0.1:5000/ || exit 1

LABEL \
    maintainer="CappyT <cappyt@eden.network>" \
    org.opencontainers.image.title="Valetudo Proxy" \
    org.opencontainers.image.description="Proxy addon for Valetudo" \
    org.opencontainers.image.authors="CappyT <cappyt@eden.network>" \
    org.opencontainers.image.licenses="MIT" \
    org.opencontainers.image.documentation="https://github.com/CappyT/hass-utilities/blob/main/valetudo_proxy/README.md"
