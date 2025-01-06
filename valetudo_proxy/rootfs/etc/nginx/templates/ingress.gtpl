server {
    listen 5000 default_server;

    include /etc/nginx/includes/server_params.conf;

    location / {
        allow   172.30.32.2;
        deny    all;

        proxy_pass http://{{ .server }};
        include /etc/nginx/includes/proxy_params.conf;
    }
}