/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jobs;

// [START job_search_get_job_beta]

import com.google.cloud.talent.v4beta1.GetJobRequest;
import com.google.cloud.talent.v4beta1.Job;
import com.google.cloud.talent.v4beta1.JobName;
import com.google.cloud.talent.v4beta1.JobServiceClient;
import com.google.cloud.talent.v4beta1.JobWithTenantName;

import java.io.IOException;

public class JobSearchGetJob {

  public static void getJob() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String tenantId = "your-tenant-id";
    String jobId = "your-job-id";
    getJob(projectId, tenantId, jobId);
  }

  // Get Job.
  public static void getJob(String projectId, String tenantId, String jobId) throws IOException {
    try (JobServiceClient jobServiceClient = JobServiceClient.create()) {
      JobName name = JobWithTenantName.of(projectId, tenantId, jobId);

      GetJobRequest request = GetJobRequest.newBuilder().setName(name.toString()).build();

      Job response = jobServiceClient.getJob(request);
      System.out.printf("Job name: %s\n", response.getName());
      System.out.printf("Requisition ID: %s\n", response.getRequisitionId());
      System.out.printf("Title: %s\n", response.getTitle());
      System.out.printf("Description: %s\n", response.getDescription());
      System.out.printf("Posting language: %s\n", response.getLanguageCode());
      for (String address : response.getAddressesList()) {
        System.out.printf("Address: %s\n", address);
      }
      for (String email : response.getApplicationInfo().getEmailsList()) {
        System.out.printf("Email: %s\n", email);
      }
      for (String websiteUri : response.getApplicationInfo().getUrisList()) {
        System.out.printf("Website: %s\n", websiteUri);
      }
    }
  }
}
// [END job_search_get_job_beta]
