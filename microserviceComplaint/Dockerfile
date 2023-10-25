FROM node:17

# Working dir
WORKDIR /usr/src/app

# Copy Package Json Files
COPY package*.json ./

# Install Prettier ( for out package's build function)
RUN npm install prettier -g

# Install files
RUN npm install \
    npm install eureka-js-client --save

# Copy Source Files
Copy . .

# Build
#RUN npm run build

#Expose the API Port
EXPOSE 5000
CMD ["npm", "start"]
